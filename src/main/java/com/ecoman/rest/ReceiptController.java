package com.ecoman.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecoman.async.ReceiptQueueManager;
import com.ecoman.exception.CustomException;
import com.ecoman.jpa.Receipt;
import com.ecoman.jpa.ReceiptLine;
import com.ecoman.jpa.ReceiptRepo;

@Controller
@Transactional(rollbackFor={Throwable.class})
public class ReceiptController {
	@Autowired
	private ReceiptRepo receiptRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReceiptQueueManager queueManager;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/receipt/advanced_search",produces="application/json; charset=UTF-8", method = RequestMethod.GET)
	HttpEntity advancedSearch(Pageable page,
							  PagedResourcesAssembler<Receipt> assembler,
							  @RequestParam(value="status", required = false) String status,
							  @RequestParam(value="customerKey", required = false) Long customerKey,
							  @RequestParam(value="supplierKey", required = false) Long supplierKey,
							  @RequestParam(value="poNo", required = false) String poNo,
							  @RequestParam(value="referenceNo", required = false) String referenceNo,
							  @RequestParam(value="containerNo", required = false) String containerNo,
							  @RequestParam(value="scheduleDate", required = false) String scheduleDateStr,
							  @RequestParam(value="appointmentDate", required = false) String appointmentDateStr,
							  @RequestParam(value="inYardDate", required = false) String inYardDateStr
							  ) throws Exception {
		Date scheduleDate = scheduleDateStr == null || scheduleDateStr.length() == 0  ? null : dateFormat.parse(scheduleDateStr);
		Date appointmentDate = appointmentDateStr == null || appointmentDateStr.length() == 0  ? null : dateFormat.parse(appointmentDateStr);
		Date inYardDate = inYardDateStr == null || inYardDateStr.length() == 0  ? null : dateFormat.parse(inYardDateStr);
		Page<Receipt> receipts = receiptRepo.advancedSearch(status, customerKey, supplierKey, poNo, referenceNo, containerNo, scheduleDate, appointmentDate, inYardDate, page);
	    return new ResponseEntity<>(assembler.toResource(receipts), HttpStatus.OK);
	}
	
	//演示添加记录
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/receipt",produces="application/json; charset=UTF-8", method = RequestMethod.POST)
	HttpEntity createReceipt(@RequestBody @Valid Receipt receipt){
		//TODO 进行必要的校验……
		if(receipt.getCustomerId().equals("")) throw new DataIntegrityViolationException("Invalid Customer");
		
		for(ReceiptLine line: receipt.getLines()){
			line.setReceipt(receipt);
		}
		return new ResponseEntity<>(receiptRepo.save(receipt), HttpStatus.OK);
	}
	//演示读取记录
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/receipt/{rid}",produces="application/json; charset=UTF-8", method = RequestMethod.GET)
	HttpEntity readReceipt(@PathVariable("rid") Long rid, HttpServletResponse resp ){
		//演示混合使用直接JDBC SQL和JPA，并无矛盾
		jdbcTemplate.execute("update receipts set date_created = now() where receipt_id = "+rid);
		
		Receipt r = receiptRepo.findOne(rid);
		return new ResponseEntity<>(r, r==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	//演示删除记录
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/receipt/{rid}",produces="application/json; charset=UTF-8", method = RequestMethod.DELETE)
	HttpEntity deleteReceipt(@PathVariable("rid") Long rid ){
		//TODO 进行必要的校验……
		Receipt r = receiptRepo.findOne(rid);
		if(r!=null) receiptRepo.delete(rid);
		return new ResponseEntity<>(r, r==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	
	//演示异步添加记录
	@RequestMapping(value="/receipt/async",produces="application/json; charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	Map<String, Object> createReceiptAsync(@RequestBody Receipt receipt) throws Exception {
		//TODO 进行必要的校验……
		for(ReceiptLine line: receipt.getLines()){
			line.setReceipt(receipt);
		}
		
		Map<String,Object> r =new HashMap<String,Object>();
		r.put("token", queueManager.addReceipt(receipt));
		return r;
	}
	
	//查询异步完成情况
	@RequestMapping(value="/receipt/async/{token}",produces="application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	Map<String,Object> createReceiptAsyncResult(@PathVariable("token") String token){
		Map<String,Object> r =new HashMap<String,Object>();
		r.put("finished", queueManager.isFinished(token));
		return r;
	}
	
	//演示自定义异常处理函数，见ErrorController.java
	@RequestMapping(value="/custom_err_test",produces="application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	Map<String,Object> customErrTest(@RequestParam(value="errno", required = false, defaultValue="0") int errno ){
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("success", true);
		if(errno == 0) return m;
		throw new CustomException(errno, "自定义异常");
	}
}
