package com.example.android.miwok;

import java.lang.reflect.Constructor;

/**
 * Created by Abhinav on 4/16/18. Word represents Vocabulary word that user wants to learn
 */
public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    //now whenever NO_IMAGE_PROVIDED is updated to something else, mImageResourceId know that there is an image
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1; //-1 because it has no meaning and out of usage

    //variable for storing ResourceId for audio
    private int mAudioResourceId;

    // we will have 2 constructors here, as phrases part doesn't need an image with it.
    //rest 3 parts require an image along with 2 texts
    public Word(String DefaultTranslation, String MiwokTranslation, int imageResourceId, int audioResourceId)
    {
        mDefaultTranslation = DefaultTranslation;

        mMiwokTranslation = MiwokTranslation;

        mImageResourceId = imageResourceId;

        mAudioResourceId = audioResourceId;

    }

    //called if there is no image
    public Word(String DefaultTranslation, String MiwokTranslation, int audioResourceId)
    {
        mDefaultTranslation = DefaultTranslation;

        mMiwokTranslation = MiwokTranslation;

        mAudioResourceId = audioResourceId;

    }
    //Methods
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslationTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    //method which tells if there is an image for this word
    public boolean hasImage()
    {
        //returns true if mImageResourceId is not equal to -1 i.e.,image is present
         return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() { return mAudioResourceId; }
}
