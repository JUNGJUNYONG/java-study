package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV() {
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		power = on;
	}
	
	public void channel(int channel) {
		if(!power) {
			return;
		}
		
		if(channel < 1) {
			channel = 255;
		} else if( channel > 255) {
			channel = 1;
		}
		
		this.channel = channel;
	}
	
	public void channel(boolean up) {
//		if(up) {
//			channel = channel + 1;
//		} else {
//			channel = channel - 1;
//		}
//		channel(channel);
		
		channel(channel + (up ? 1 : -1));
	}

	public void volume(int volume) {
		if(!power) {
			return;
		}
		
		if(volume < 1) {
			volume = 255;
		} else if( volume > 255) {
			volume = 1;
		}
		
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
	}
	
	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
}
