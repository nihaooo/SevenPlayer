package com.qzr.sevenplayer.manager;

import android.view.Surface;

import com.qzr.sevenplayer.decode.AudioDecodeService;
import com.qzr.sevenplayer.decode.VideoDecodeService;

/**
 * @ProjectName: SevenPlayer
 * @Package: com.qzr.sevenplayer.manager
 * @ClassName: DecorderManager
 * @Description:
 * @Author: qzhuorui
 * @CreateDate: 2020/8/15 11:09
 */
public class DecorderManager {
    private static final String TAG = "DecorderManager";

    VideoDecodeService mVideoDecodeService;
    AudioDecodeService mAudioDecodeService;

    public static DecorderManager getInstance() {
        return DecorderManager.DecorderManagerHolder.decorderManager;
    }

    private static class DecorderManagerHolder {
        private static DecorderManager decorderManager = new DecorderManager();
    }

    public DecorderManager() {
    }

    public void buildMediaDecode(String filePath, Surface surface) {
        mVideoDecodeService = VideoDecodeService.getInstance().buildVideoDecorderWithParam(filePath, surface);
        mVideoDecodeService.startVideoDecode();
    }

    public void startMediaDecode() {
        mVideoDecodeService.startTransmit2Surface();
    }

    public void stopMediaDecode() {
        mVideoDecodeService.stopVideoDecoding();
        mVideoDecodeService.stopVideoDecode();
        mVideoDecodeService.releaseVideoDecode();
        mVideoDecodeService = null;
    }
}
