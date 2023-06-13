package com.adminservice.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adminservice.entity.Event;
import com.adminservice.exceptions.EventNotFoundException;
import com.adminservice.respository.EventRepository;
import com.adminservice.service.EventService;
import com.adminservice.utils.ImageUtils;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() {
		logger.info("Fetching all events");
		List<Event> list = eventRepository.findAll();
		List<Event> filteredList = list.stream()
				.filter(e -> e.getDeleteStatus().equals(Boolean.FALSE))
				.collect(Collectors.toList());
		filteredList.stream()
				.forEach(e->e.setEventImage(ImageUtils.decompressImage(e.getEventImage())));
		logger.info("Returning {} events", filteredList.size());
		return filteredList;
	}

	@Override
	public String addEvent(Event event, MultipartFile eventImage) {
		logger.info("Adding event: {}", event.getEventName());
		try {
			event.setEventImage(ImageUtils.compressImage(eventImage.getBytes()));
		} catch (IOException e) {
			logger.error("Error compressing event image", e);
			return "Image could not be set for the event data";
		}

		Event check = eventRepository.save(event);

		if (check != null) {
			logger.info("Event data and image uploaded successfully");
			return "Event data and image uploaded successfully";
		}

		logger.error("Failed to upload event image");
		return "Image could not be uploaded";
	}

	@Override
	public Object getEventByEventId(Long eventId) {
		logger.info("Fetching event with ID: {}", eventId);
		Optional<Event> event = eventRepository.findById(eventId);
		if (event.isPresent()) {
			logger.info("Event found with ID: {}", eventId);
			byte[] image = ImageUtils.decompressImage(event.get().getEventImage());
			event.get().setEventImage(image);
			return event.get();
		} else {
			logger.warn("Event not found with ID: {}", eventId);
			return null;
		}
	}

	public Object updateEvent(Long eventIdToUpdate, Event event, MultipartFile eventImage) {
		logger.info("Updating event with ID: {}", eventIdToUpdate);
		if (!(getEventByEventId(eventIdToUpdate) instanceof Event)) {
			logger.warn("No event found with ID: {}", eventIdToUpdate);
			return "No event found with this ID";
		} else {
			try {
				event.setEventImage(ImageUtils.compressImage(eventImage.getBytes()));
			} catch (IOException e) {
				logger.error("Error compressing event image", e);
				return "Image could not be set for the event data";
			}

			Event eventToUpdate = eventRepository.findById(eventIdToUpdate).get();
			eventToUpdate.setEventName(event.getEventName());
			eventToUpdate.setRegistrationOpenDate(event.getRegistrationOpenDate());
			eventToUpdate.setRegistrationCloseDate(event.getRegistrationCloseDate());
			eventToUpdate.setEventStartTime(event.getEventStartTime());
			eventToUpdate.setEventCloseTime(event.getEventCloseTime());
			eventToUpdate.setRegistrationFee(event.getRegistrationFee());
			eventToUpdate.setEventCapacity(event.getEventCapacity());
			eventToUpdate.setBreakfastPrice(event.getBreakfastPrice());
			eventToUpdate.setLunchPrice(event.getLunchPrice());
			eventToUpdate.setDinnerPrice(event.getDinnerPrice());
			eventToUpdate.setDeleteStatus(event.getDeleteStatus());
			eventToUpdate.setEventImage(event.getEventImage());

			Event check = eventRepository.save(eventToUpdate);

			if (check != null) {
				logger.info("Event data and image updated successfully");
				return "Event data and image updated successfully";
			}

			logger.error("Failed to update event image");
			return "Image could not be uploaded";
		}
	}

	@Override
	public Object deleteEventById(Long eventIdToDelete) {
	    logger.info("Deleting event with ID: {}", eventIdToDelete);
	    Optional<Event> event = eventRepository.findById(eventIdToDelete);
	    
	    if (event.isPresent()) {
	    	event.get().setDeleteStatus(true);
	        eventRepository.save(event.get());
	        logger.info("Event deleted successfully");
	        return "Event deleted successfully";
	    } else {
	        logger.warn("Event not found with ID: {}", eventIdToDelete);
	        
	        throw new EventNotFoundException("Event Not Found");
	    }
	}

}
