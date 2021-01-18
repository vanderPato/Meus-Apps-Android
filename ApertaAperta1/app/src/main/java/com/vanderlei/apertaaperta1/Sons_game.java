package com.vanderlei.apertaaperta1;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class Sons_game {
    private AudioAttributes audioAttributes;
    private final int SOND_POOL_MAX = 3;

    private static SoundPool soundPool;
    private static int hitBallSound;
    private static int hitBlackSound;
    private static int timeOverSound;


    public Sons_game(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();


            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(SOND_POOL_MAX)
                    .build();
        }else{
            soundPool = new SoundPool(SOND_POOL_MAX, AudioManager.STREAM_MUSIC,0);
        }

        hitBallSound = soundPool.load(context,R.raw.acertou_editado,1);
        hitBlackSound = soundPool.load(context,R.raw.erro_editado,1);

    }

    public void playAcertou(){
        soundPool.play(hitBallSound,1.0f,1.0f,1,0,1.0f);
    }


    public void playErrou(){
        soundPool.play(hitBlackSound,1.0f,1.0f,1,0,1.0f);
    }

}
