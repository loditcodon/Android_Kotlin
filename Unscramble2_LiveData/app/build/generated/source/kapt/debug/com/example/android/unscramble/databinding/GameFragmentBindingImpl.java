package com.example.android.unscramble.databinding;
import com.example.android.unscramble.R;
import com.example.android.unscramble.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class GameFragmentBindingImpl extends GameFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.skip, 4);
        sViewsWithIds.put(R.id.submit, 5);
        sViewsWithIds.put(R.id.textView_instructions, 6);
        sViewsWithIds.put(R.id.textField, 7);
        sViewsWithIds.put(R.id.text_input_edit_text, 8);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public GameFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private GameFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.TextView) bindings[3]
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.score.setTag(null);
        this.textViewUnscrambledWord.setTag(null);
        this.wordCount.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.gameViewModel == variableId) {
            setGameViewModel((com.example.android.unscramble.ui.game.GameViewModel) variable);
        }
        else if (BR.maxNoOfWords == variableId) {
            setMaxNoOfWords((int) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGameViewModel(@Nullable com.example.android.unscramble.ui.game.GameViewModel GameViewModel) {
        this.mGameViewModel = GameViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.gameViewModel);
        super.requestRebind();
    }
    public void setMaxNoOfWords(int MaxNoOfWords) {
        this.mMaxNoOfWords = MaxNoOfWords;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.maxNoOfWords);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeGameViewModelScore((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeGameViewModelCurrentWordCount((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeGameViewModelCurrentScrambledWord((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeGameViewModelScore(androidx.lifecycle.LiveData<java.lang.Integer> GameViewModelScore, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGameViewModelCurrentWordCount(androidx.lifecycle.LiveData<java.lang.Integer> GameViewModelCurrentWordCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeGameViewModelCurrentScrambledWord(androidx.lifecycle.LiveData<java.lang.String> GameViewModelCurrentScrambledWord, int fieldId) {
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
        androidx.lifecycle.LiveData<java.lang.Integer> gameViewModelScore = null;
        java.lang.Integer gameViewModelCurrentWordCountGetValue = null;
        java.lang.String gameViewModelCurrentScrambledWordGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Integer> gameViewModelCurrentWordCount = null;
        java.lang.String scoreAndroidStringScoreGameViewModelScore = null;
        androidx.lifecycle.LiveData<java.lang.String> gameViewModelCurrentScrambledWord = null;
        java.lang.String wordCountAndroidStringWordCountGameViewModelCurrentWordCountMaxNoOfWords = null;
        java.lang.Integer gameViewModelScoreGetValue = null;
        com.example.android.unscramble.ui.game.GameViewModel gameViewModel = mGameViewModel;
        int maxNoOfWords = mMaxNoOfWords;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x29L) != 0) {

                    if (gameViewModel != null) {
                        // read gameViewModel.score
                        gameViewModelScore = gameViewModel.getScore();
                    }
                    updateLiveDataRegistration(0, gameViewModelScore);


                    if (gameViewModelScore != null) {
                        // read gameViewModel.score.getValue()
                        gameViewModelScoreGetValue = gameViewModelScore.getValue();
                    }


                    // read @android:string/score
                    scoreAndroidStringScoreGameViewModelScore = score.getResources().getString(R.string.score, gameViewModelScoreGetValue);
            }
            if ((dirtyFlags & 0x3aL) != 0) {

                    if (gameViewModel != null) {
                        // read gameViewModel.currentWordCount
                        gameViewModelCurrentWordCount = gameViewModel.getCurrentWordCount();
                    }
                    updateLiveDataRegistration(1, gameViewModelCurrentWordCount);


                    if (gameViewModelCurrentWordCount != null) {
                        // read gameViewModel.currentWordCount.getValue()
                        gameViewModelCurrentWordCountGetValue = gameViewModelCurrentWordCount.getValue();
                    }
            }
            if ((dirtyFlags & 0x2cL) != 0) {

                    if (gameViewModel != null) {
                        // read gameViewModel.currentScrambledWord
                        gameViewModelCurrentScrambledWord = gameViewModel.getCurrentScrambledWord();
                    }
                    updateLiveDataRegistration(2, gameViewModelCurrentScrambledWord);


                    if (gameViewModelCurrentScrambledWord != null) {
                        // read gameViewModel.currentScrambledWord.getValue()
                        gameViewModelCurrentScrambledWordGetValue = gameViewModelCurrentScrambledWord.getValue();
                    }
            }
        }
        if ((dirtyFlags & 0x3aL) != 0) {



                // read @android:string/word_count
                wordCountAndroidStringWordCountGameViewModelCurrentWordCountMaxNoOfWords = wordCount.getResources().getString(R.string.word_count, gameViewModelCurrentWordCountGetValue, maxNoOfWords);
        }
        // batch finished
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.score, scoreAndroidStringScoreGameViewModelScore);
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewUnscrambledWord, gameViewModelCurrentScrambledWordGetValue);
        }
        if ((dirtyFlags & 0x3aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.wordCount, wordCountAndroidStringWordCountGameViewModelCurrentWordCountMaxNoOfWords);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): gameViewModel.score
        flag 1 (0x2L): gameViewModel.currentWordCount
        flag 2 (0x3L): gameViewModel.currentScrambledWord
        flag 3 (0x4L): gameViewModel
        flag 4 (0x5L): maxNoOfWords
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}