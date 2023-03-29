package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.stock.entity.Attachment;
import uz.pdp.stock.entity.AttachmentContent;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.AttachmentContentRepository;
import uz.pdp.stock.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    final AttachmentRepository attachmentRepository;
    final AttachmentContentRepository attachmentContentRepository;
    public ResultMessage upload(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileName = request.getFileNames();
        if (!fileName.hasNext())
            return new ResultMessage("File not found", false);

        MultipartFile file = request.getFile(fileName.next());
        Attachment attachment = new Attachment();
        if (file != null) {
            attachment.setName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setContentType(file.getContentType());
            Attachment save = attachmentRepository.save(attachment);
        }
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContentRepository.save(attachmentContent);
            return new ResultMessage("File successfully added", true);
        }
}
