package com.ecoman.jpa;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="receipt")
public interface ReceiptRepo extends PagingAndSortingRepository<Receipt,Long> {
	Page<Receipt> findByOrderByDateCreated(Pageable page);
	
	@Query("select r from Receipt r where r.id > 0 and "+
		   "(:status is NULL or r.status = :status) and "+
		   "(:customerKey is NULL or :customerKey = 0 or r.customerKey = :customerKey) and "+
		   "(:supplierKey is NULL or :supplierKey = 0 or r.supplierKey = :supplierKey) and "+
		   "(:poNo is NULL or r.poNo = :poNo) and "+
		   "(:referenceNo is NULL or r.referenceNo = :referenceNo) and "+
		   "(:containerNo is NULL or r.containerNo = :containerNo) and "+
		   "(:scheduleDate is NULL or r.scheduleDate = :scheduleDate) and "+
		   "(:appointmentDate is NULL or r.appointmentDate = :appointmentDate) and "+
		   "(:inYardDate is NULL or r.inYardDate = :inYardDate)")
	Page<Receipt> advancedSearch(@Param("status") String status,
								 @Param("customerKey") Long customerKey,
								 @Param("supplierKey") Long supplierKey,
								 @Param("poNo") String poNo,
								 @Param("referenceNo") String referenceNo,
								 @Param("containerNo") String containerNo,
								 @Param("scheduleDate") Date scheduleDate,
								 @Param("appointmentDate") Date appointmentDate,
								 @Param("inYardDate") Date inYardDate,
							  	 Pageable page);
}
