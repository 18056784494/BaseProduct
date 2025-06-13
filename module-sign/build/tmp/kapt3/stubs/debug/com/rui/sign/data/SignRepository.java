package com.rui.sign.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/rui/sign/data/SignRepository;", "Lcom/rui/mvvmlazy/base/BaseModel;", "Lcom/rui/sign/data/source/HttpDataSource;", "Lcom/rui/sign/data/source/LocalDataSource;", "()V", "mHttpDataSource", "Lcom/rui/sign/data/source/http/HttpDataSourceImpl;", "getMHttpDataSource", "()Lcom/rui/sign/data/source/http/HttpDataSourceImpl;", "mHttpDataSource$delegate", "Lkotlin/Lazy;", "mLocalDataSource", "Lcom/rui/sign/data/source/local/LocalDataSourceImpl;", "getMLocalDataSource", "()Lcom/rui/sign/data/source/local/LocalDataSourceImpl;", "mLocalDataSource$delegate", "sendCode", "Lcom/rui/mvvmlazy/http/BaseResponse;", "", "phone", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "module-sign_debug"})
public final class SignRepository extends com.rui.mvvmlazy.base.BaseModel implements com.rui.sign.data.source.HttpDataSource, com.rui.sign.data.source.LocalDataSource {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mHttpDataSource$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mLocalDataSource$delegate = null;
    
    public SignRepository() {
        super();
    }
    
    private final com.rui.sign.data.source.http.HttpDataSourceImpl getMHttpDataSource() {
        return null;
    }
    
    private final com.rui.sign.data.source.local.LocalDataSourceImpl getMLocalDataSource() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendCode(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rui.mvvmlazy.http.BaseResponse<kotlin.Unit>> $completion) {
        return null;
    }
}