package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.stock.entity.Attachment;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.AttachmentService;

import java.io.IOException;

@RestController
@RequestMapping("/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentService attachmentService;
   @PostMapping
    public ResultMessage upload(MultipartHttpServletRequest request) throws IOException {
       return attachmentService.upload(request);
   }

}
