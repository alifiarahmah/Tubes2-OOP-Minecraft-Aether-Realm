package com.aetherwars.event;

import com.aetherwars.model.*;
public class PhaseChangedEvent implements Event {
	private Phase cur_phase;
	
	public PhaseChangedEvent(Phase cur_phase) {
		this.cur_phase = cur_phase;
	}
	@Override
	public Object getInfo() {
		// TODO Auto-generated method stub
		return this.cur_phase;
	}

}
