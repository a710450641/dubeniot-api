/**
 * 
 */
package com.dubeniot.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author BUB-4
 *
 */
public interface PictureService {
	Map uploadPicture(MultipartFile uploadFile);
}
