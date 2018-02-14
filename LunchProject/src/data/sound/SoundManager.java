package data.sound;

import org.lwjgl.util.WaveData;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class SoundManager {

	/**
	 * Some basic info you sohuld know pnames: AL_BUFFER, AL_POSITION, AL_PITCH,
	 * AL_GAIN, AL_VELOCITY
	 * 
	 */
	/** Buffers hold sound data. */
	IntBuffer buffer;
	/** Sources are points emitting sound. */
	IntBuffer source;

	/** Position of the source sound. */
	FloatBuffer sourcePos;

	/** Velocity of the source sound. */
	FloatBuffer sourceVel;

	/** Position of the listener. */
	FloatBuffer listenerPos;

	/** Velocity of the listener. */
	FloatBuffer listenerVel;

	/**
	 * Orientation of the listener. (first 3 elements are "at", second 3 are "up")
	 */
	FloatBuffer listenerOri;

	public SoundManager(String file) {
		loadALData(file);
		playSound();
	}
	
	public SoundManager() {
		
	}
	
	public int loadALData(String file) {
		buffer = BufferUtils.createIntBuffer(1);
		source = BufferUtils.createIntBuffer(1);
		sourcePos = BufferUtils.createFloatBuffer(3).put(new float[] { 0.0f, 0.0f, 0.0f });
		sourceVel = BufferUtils.createFloatBuffer(3).put(new float[] { 0.0f, 0.0f, 0.0f });
		listenerPos = BufferUtils.createFloatBuffer(3).put(new float[] { 0.0f, 0.0f, 0.0f });
		listenerVel = BufferUtils.createFloatBuffer(3).put(new float[] { 0.0f, 0.0f, 0.0f });
		listenerOri = BufferUtils.createFloatBuffer(6).put(new float[] { 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f });
		try {
			AL10.alGenBuffers(buffer);

			if (AL10.alGetError() != AL10.AL_NO_ERROR)
				return AL10.AL_FALSE;
			WaveData waveFile = WaveData.create(file);
			AL10.alBufferData(buffer.get(0), waveFile.format, waveFile.data, waveFile.samplerate);
			waveFile.dispose();

			AL10.alGenSources(source);

			if (AL10.alGetError() != AL10.AL_NO_ERROR)
				return AL10.AL_FALSE;

			AL10.alSourcei(source.get(0), AL10.AL_BUFFER, buffer.get(0));
			AL10.alSourcef(source.get(0), AL10.AL_PITCH, 1.0f);
			AL10.alSourcef(source.get(0), AL10.AL_GAIN, 1.0f);
			//AL10.alSource(source.get(0), AL10.AL_POSITION, sourcePos);
			//AL10.alSource(source.get(0), AL10.AL_VELOCITY, sourceVel);

			//setListenerValues();
			
			if (AL10.alGetError() == AL10.AL_NO_ERROR)
				return AL10.AL_TRUE;

			return AL10.AL_FALSE;
		} catch (Exception e) {
			e.printStackTrace();
			return AL10.AL_FALSE;
		}
	}

	public void setListenerValues() {
		AL10.alListener(AL10.AL_POSITION, listenerPos);
		AL10.alListener(AL10.AL_VELOCITY, listenerVel);
		AL10.alListener(AL10.AL_ORIENTATION, listenerOri);
	}

	public void killALData() {
		AL10.alDeleteSources(source);
		AL10.alDeleteBuffers(buffer);
	}
	
	public void playSound() {
		AL10.alSourcePlay(source.get(0));
	}
	
	public void stopSound() {
		AL10.alSourceStop(source.get(0));
	}
	
	public void pauseSound() {
		AL10.alSourcePause(source.get(0));
	}

}
