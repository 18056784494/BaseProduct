package com.rui.sign.data.source;

/**
 * Created by zjr on 2019/3/26.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/rui/sign/data/source/HttpDataSource;", "", "sendCode", "Lcom/rui/mvvmlazy/http/BaseResponse;", "", "phone", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "module-sign_debug"})
public abstract interface HttpDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rui.mvvmlazy.http.BaseResponse<kotlin.Unit>> $completion);
}