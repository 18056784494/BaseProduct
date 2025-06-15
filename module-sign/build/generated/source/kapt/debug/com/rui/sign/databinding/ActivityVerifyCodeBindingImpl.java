package com.rui.sign.databinding;
import com.rui.sign.R;
import com.rui.sign.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityVerifyCodeBindingImpl extends ActivityVerifyCodeBinding implements com.rui.sign.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_code_container, 3);
        sViewsWithIds.put(R.id.et_code_0, 4);
        sViewsWithIds.put(R.id.et_code_1, 5);
        sViewsWithIds.put(R.id.et_code_2, 6);
        sViewsWithIds.put(R.id.et_code_3, 7);
        sViewsWithIds.put(R.id.et_code_4, 8);
        sViewsWithIds.put(R.id.et_code_5, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityVerifyCodeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityVerifyCodeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[9]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvResend.setTag(null);
        this.tvSendTip.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.rui.sign.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.rui.sign.ui.VerifyCodeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.rui.sign.ui.VerifyCodeViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelSendTip((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelResendText((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelCanResend((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelSendTip(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelSendTip, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelResendText(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelResendText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelCanResend(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelCanResend, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModelSendTipGetValue = null;
        java.lang.String viewModelResendTextGetValue = null;
        java.lang.Boolean viewModelCanResendGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelSendTip = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelCanResendGetValue = false;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelResendText = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelCanResend = null;
        com.rui.sign.ui.VerifyCodeViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.sendTip
                        viewModelSendTip = viewModel.getSendTip();
                    }
                    updateLiveDataRegistration(0, viewModelSendTip);


                    if (viewModelSendTip != null) {
                        // read viewModel.sendTip.getValue()
                        viewModelSendTipGetValue = viewModelSendTip.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.resendText
                        viewModelResendText = viewModel.getResendText();
                    }
                    updateLiveDataRegistration(1, viewModelResendText);


                    if (viewModelResendText != null) {
                        // read viewModel.resendText.getValue()
                        viewModelResendTextGetValue = viewModelResendText.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.canResend
                        viewModelCanResend = viewModel.getCanResend();
                    }
                    updateLiveDataRegistration(2, viewModelCanResend);


                    if (viewModelCanResend != null) {
                        // read viewModel.canResend.getValue()
                        viewModelCanResendGetValue = viewModelCanResend.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.canResend.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCanResendGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCanResendGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvResend, viewModelResendTextGetValue);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.tvResend.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelCanResendGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.tvResend.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSendTip, viewModelSendTipGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.rui.sign.ui.VerifyCodeViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.resendCode();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.sendTip
        flag 1 (0x2L): viewModel.resendText
        flag 2 (0x3L): viewModel.canResend
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}