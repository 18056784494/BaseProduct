package com.rui.sign.data.source.http;

/**
 * Created by zjr on 2019/3/26.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/rui/sign/data/source/http/HttpDataSourceImpl;", "Lcom/rui/sign/data/source/HttpDataSource;", "apiService", "Lcom/rui/sign/data/source/http/service/SignApiService;", "(Lcom/rui/sign/data/source/http/service/SignApiService;)V", "sendCode", "Lcom/rui/mvvmlazy/http/BaseResponse;", "", "phone", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyCode", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "module-sign_debug"})
public final class HttpDataSourceImpl implements com.rui.sign.data.source.HttpDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.rui.sign.data.source.http.service.SignApiService apiService = null;
    
    public HttpDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.rui.sign.data.source.http.service.SignApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rui.mvvmlazy.http.BaseResponse<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object verifyCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rui.mvvmlazy.http.BaseResponse<kotlin.Unit>> $completion) {
        return null;
    }
}