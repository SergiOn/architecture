package com.so.authorization.service;

import com.so.authorization.exception.AuthorizationTokenDuplicateException;
import com.so.authorization.exception.AuthorizationTokenNotFoundException;
import com.so.authorization.exception.AuthorizationTokenUpdateException;
import com.so.authorization.model.request.CreateTokenInformation;
import com.so.authorization.model.request.UpdateTokenInformation;
import com.so.authorization.model.response.UserCredentialsResponse;

public interface AuthorizationService {

    UserCredentialsResponse getUserCredentials(
            final String authorizationHeader,
            final String userAgentHeader,
            final String forwardedHeader
    ) throws AuthorizationTokenNotFoundException;

    void registerUserCredentials(
            final String userAgentHeader,
            final String forwardedHeader,
            final CreateTokenInformation createTokenInformation
    ) throws AuthorizationTokenDuplicateException;

    void updateUserCredentials(final UpdateTokenInformation updateTokenInformation) throws AuthorizationTokenUpdateException;

    void deleteUserCredentials(final String authorizationHeader);

    void deleteAllUserCredentials(final Long userId);
}
