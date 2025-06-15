package com.rui.sign.databinding;
import com.rui.sign.R;
import com.rui.sign.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.rui.sign.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_title, 4);
        sViewsWithIds.put(R.id.btn_wechat, 5);
        sViewsWithIds.put(R.id.btn_apple, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener cbAgreeandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.isAgreementChecked.getValue()
            //         is viewModel.isAgreementChecked.setValue((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = cbAgree.isChecked();
            // localize variables for thread safety
            // viewModel.isAgreementChecked
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsAgreementChecked = null;
            // viewModel
            com.rui.sign.ui.LoginViewModel viewModel = mViewModel;
            // viewModel.isAgreementChecked.getValue()
            java.lang.Boolean viewModelIsAgreementCheckedGetValue = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.isAgreementChecked != null
            boolean viewModelIsAgreementCheckedJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelIsAgreementChecked = viewModel.isAgreementChecked();

                viewModelIsAgreementCheckedJavaLangObjectNull = (viewModelIsAgreementChecked) != (null);
                if (viewModelIsAgreementCheckedJavaLangObjectNull) {




                    viewModelIsAgreementChecked.setValue(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etPhoneandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.phone.getValue()
            //         is viewModel.phone.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etPhone);
            // localize variables for thread safety
            // viewModel.phone != null
            boolean viewModelPhoneJavaLangObjectNull = false;
            // viewModel
            com.rui.sign.ui.LoginViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.phone
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPhone = null;
            // viewModel.phone.getValue()
            java.lang.String viewModelPhoneGetValue = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPhone = viewModel.getPhone();

                viewModelPhoneJavaLangObjectNull = (viewModelPhone) != (null);
                if (viewModelPhoneJavaLangObjectNull) {




                    viewModelPhone.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.ImageButton) bindings[6]
            , (android.widget.Button) bindings[2]
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.CheckBox) bindings[3]
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[4]
            );
        this.btnGetCode.setTag(null);
        this.cbAgree.setTag(null);
        this.etPhone.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.rui.sign.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setViewModel((com.rui.sign.ui.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.rui.sign.ui.LoginViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsAgreementChecked((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeViewModelPhone((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsAgreementChecked(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsAgreementChecked, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelPhone(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelPhone, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsAgreementChecked = null;
        java.lang.Boolean viewModelIsAgreementCheckedGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPhone = null;
        java.lang.String viewModelPhoneGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsAgreementCheckedGetValue = false;
        com.rui.sign.ui.LoginViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isAgreementChecked
                        viewModelIsAgreementChecked = viewModel.isAgreementChecked();
                    }
                    updateLiveDataRegistration(0, viewModelIsAgreementChecked);


                    if (viewModelIsAgreementChecked != null) {
                        // read viewModel.isAgreementChecked.getValue()
                        viewModelIsAgreementCheckedGetValue = viewModelIsAgreementChecked.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isAgreementChecked.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelIsAgreementCheckedGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsAgreementCheckedGetValue);
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.phone
                        viewModelPhone = viewModel.getPhone();
                    }
                    updateLiveDataRegistration(1, viewModelPhone);


                    if (viewModelPhone != null) {
                        // read viewModel.phone.getValue()
                        viewModelPhoneGetValue = viewModelPhone.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btnGetCode.setOnClickListener(mCallback2);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.cbAgree, (android.widget.CompoundButton.OnCheckedChangeListener)null, cbAgreeandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etPhone, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etPhoneandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.cbAgree, androidxDatabindingViewDataBindingSafeUnboxViewModelIsAgreementCheckedGetValue);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etPhone, viewModelPhoneGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.rui.sign.ui.LoginViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.getCode();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isAgreementChecked
        flag 1 (0x2L): viewModel.phone
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}