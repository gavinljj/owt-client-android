/*
 * Intel License Header Holder
 */
package com.intel.webrtc.conference;

import com.intel.webrtc.base.AudioEncodingParameters;
import com.intel.webrtc.base.VideoEncodingParameters;

import java.util.ArrayList;
import java.util.List;

import static com.intel.webrtc.base.CheckCondition.RCHECK;

/**
 * Options for publishing a LocalStream to the conference.
 */
public final class PublishOptions {

    /**
     * Builder for building up a PublishOptions.
     */
    public static class Builder {
        List<AudioEncodingParameters> audioEncodingParameters = new ArrayList<>();
        List<VideoEncodingParameters> videoEncodingParameters = new ArrayList<>();

        Builder() {
        }

        /**
         * Add a VideoEncodingParameters to be supported for publishing a LocalStream.
         * PublishOptions without any VideoEncodingParameters specified, it will support all
         * video codecs supported by the hardware devices.
         *
         * @param parameter VideoEncodingParameters to be added.
         * @return Builder
         */
        public Builder addVideoParameter(VideoEncodingParameters parameter) {
            RCHECK(parameter);
            videoEncodingParameters.add(parameter);
            return this;
        }

        /**
         * Add an AudioEncodingParameters to be supported for publishing a LocalStream.
         * PublishOptions without any VideoEncodingParameters specified, it will support all
         * audio codecs supported by the hardware devices.
         *
         * @param parameter AudioEncodingParameters to be added.
         * @return Builder
         */
        public Builder addAudioParameter(AudioEncodingParameters parameter) {
            RCHECK(parameter);
            audioEncodingParameters.add(parameter);
            return this;
        }

        /**
         * Build up a PublishOptions.
         *
         * @return PublishOptions
         */
        public PublishOptions build() {
            return new PublishOptions(audioEncodingParameters, videoEncodingParameters);
        }
    }


    final List<AudioEncodingParameters> audioEncodingParameters;
    final List<VideoEncodingParameters> videoEncodingParameters;

    /**
     * Get a Builder for creating a PublishOptions.
     *
     * @return Builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private PublishOptions(List<AudioEncodingParameters> audioParameters,
                           List<VideoEncodingParameters> videoParameters) {
        audioEncodingParameters = audioParameters;
        videoEncodingParameters = videoParameters;
    }
}