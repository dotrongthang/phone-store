package com.project.api.admin;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ProductDTO;
import com.project.dto.UploadFileDTO;
import com.project.service.IProductService;
import com.project.util.UploadFileUtils;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	
	private String nameImage;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private UploadFileUtils uploadFile;
	
	@PostMapping("/api/upload")
	public ResponseEntity<Void> uploadFile(@RequestBody UploadFileDTO photo) {
        try {
        	nameImage = photo.getName();
            byte[] decodeBase64 = Base64.getDecoder().decode(photo.getPhoto().getBytes());
            uploadFile.writeOrUpdate(decodeBase64, "/image/" + photo.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

	@PostMapping("/api/product")
	public ProductDTO createNew(@RequestBody ProductDTO productDTO) {
		return productService.save(productDTO, nameImage);
	}
	
	@PutMapping("/api/product")
	public ProductDTO updateNew(@RequestBody ProductDTO updateNew) {	
		return productService.save(updateNew, nameImage);
	}
	
	@DeleteMapping("/api/product")
	public void deleteNew(@RequestBody long[] ids) {
		productService.delete(ids);
	}
}
