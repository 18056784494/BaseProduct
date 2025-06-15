package com.rui.sign.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\rH\u0014J\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\rH\u0002J\u0006\u0010\u001e\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/rui/sign/ui/VerifyCodeViewModel;", "Lcom/rui/mvvmlazy/base/BaseViewModel;", "()V", "canResend", "Landroidx/lifecycle/MutableLiveData;", "", "getCanResend", "()Landroidx/lifecycle/MutableLiveData;", "codeInput", "", "getCodeInput", "codeResult", "Lcom/rui/mvvmlazy/state/ResultState;", "", "getCodeResult", "phone", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "resendText", "getResendText", "sendTip", "getSendTip", "timer", "Landroid/os/CountDownTimer;", "onCleared", "resendCode", "start", "startTimer", "verifyCodeAndLogin", "module-sign_debug"})
public final class VerifyCodeViewModel extends com.rui.mvvmlazy.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> sendTip = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> resendText = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> canResend = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.rui.mvvmlazy.state.ResultState<kotlin.Unit>> codeResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> codeInput = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phone = "";
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer timer;
    
    public VerifyCodeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSendTip() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getResendText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getCanResend() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.rui.mvvmlazy.state.ResultState<kotlin.Unit>> getCodeResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getCodeInput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhone() {
        return null;
    }
    
    public final void setPhone(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void start(@org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    public final void resendCode() {
    }
    
    private final void startTimer() {
    }
    
    public final void verifyCodeAndLogin() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}