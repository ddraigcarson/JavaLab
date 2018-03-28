package evolution;

public enum TimingEvent {
	START(null), END (START),
	CREATE_BOTS_START(null), CREATE_BOTS_END(CREATE_BOTS_START), 
	CREATE_BOARDS_START(null), CREATE_BOARDS_END(CREATE_BOARDS_START), 
	RESET_BOTS_START(null), RESET_BOTS_END(RESET_BOTS_START), 
	RESET_BOARDS_START(null), RESET_BOARDS_END(RESET_BOARDS_START),
	TEST_START(null), TEST_END(TEST_START),
	SEARCH_MEMORY_START(null), SEARCH_MEMORY_END(SEARCH_MEMORY_START),
	
	MAP_CREATE_START(null), MAP_CREATE_END(MAP_CREATE_START),
	MAP_FETCH_START(null), MAP_FETCH_END(MAP_FETCH_START),
	LIST_CREATE_START(null), LIST_CREATE_END(LIST_CREATE_START),
	LIST_FETCH_START(null), LIST_FETCH_END(LIST_FETCH_START)
	;
	
	private final TimingEvent triggeringEvent;

	private TimingEvent(TimingEvent triggeringEvent) {
		this.triggeringEvent = triggeringEvent;
	}

	public TimingEvent getTriggeringEvent() {
		return triggeringEvent;
	}
		
}
