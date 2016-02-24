package com.tzt.tzt_mediavideo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.SeekBar;
import android.view.View;
import android.view.View.OnClickListener;;
public class Tzt_mediavideoActivity extends Activity {
    /** Called when the activity is first created. */
	private SurfaceView  surfaceview;
	private Button butonstop, buttonstart,btnPause;
	 private SeekBar skbProgress;  
	 private player mplayer;
	 //private Player player; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
        surfaceview=(SurfaceView)this.findViewById(R.id.tzt_surfceview);
        skbProgress=(SeekBar)this.findViewById(R.id.skbProgress);
        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        btnPause = (Button) this.findViewById(R.id.btnPause);  
        btnPause.setOnClickListener(new ClickEvent());  
        buttonstart = (Button) this.findViewById(R.id.btnPlayUrl);  
        buttonstart.setOnClickListener(new ClickEvent());  
        butonstop=(Button)this.findViewById(R.id.btnStop);
        butonstop.setOnClickListener(new ClickEvent()); 
        mplayer = new player(surfaceview, skbProgress);
    }
    class ClickEvent implements OnClickListener{
    	@Override  
        public void onClick(View arg0) {  
            if (arg0 == btnPause) {  
                mplayer.pause();  
            } else if (arg0 == buttonstart) {  
                String url="http://daily3gp.com/vids/family_guy_penis_car.3gp";  
//                String url="/sdcard/Shaker.MP4";
             //   String url="http://120.196.128.11/update/shaker.mp£´";
//                String url="/sdcard/family_guy_penis_car.3gp";
                mplayer.playUrl(url);  
            } else if (arg0 == butonstop) {  
                mplayer.stop();  
            }  
  
        }  
    	
    }
    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener{
    	int progress;
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			// TODO Auto-generated method stub
			this.progress = progress * mplayer.mediaPlayer.getDuration()  
            / seekBar.getMax(); 
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			mplayer.mediaPlayer.seekTo(progress);
			
		}
    	
    }
}