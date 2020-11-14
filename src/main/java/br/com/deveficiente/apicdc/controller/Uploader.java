package br.com.deveficiente.apicdc.controller;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface Uploader {

	public String upload(MultipartFile file);
}
