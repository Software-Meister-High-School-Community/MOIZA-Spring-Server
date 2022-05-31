package com.example.moizaspringserver.domain.user.service;

import com.example.moizaspringserver.domain.user.entity.GraduateVerifyingFile;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.FileAlreadyExistsException;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import com.example.moizaspringserver.domain.user.presentation.dto.request.VerifyGraduateRequest;
import com.example.moizaspringserver.domain.user.repository.GraduateVerifyingFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VerifyGraduateService {

    private final UserFacade userFacade;
    private final GraduateVerifyingFileRepository graduateVerifyingFileRepository;

    @Transactional
    public void execute(VerifyGraduateRequest request) {
        String verifyingFileUrl = request.getVerifyingFileUrl();
        User user = userFacade.queryCurrentUser();

        if (graduateVerifyingFileRepository.findByUser(user).isPresent()) {
            throw FileAlreadyExistsException.EXCEPTION;
        }

        GraduateVerifyingFile verifyingFile = GraduateVerifyingFile.builder()
                .user(user)
                .verifyingFileUrl(verifyingFileUrl)
                .build();

        graduateVerifyingFileRepository.save(verifyingFile);
    }

}
