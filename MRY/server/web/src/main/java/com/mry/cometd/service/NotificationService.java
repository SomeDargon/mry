package com.mry.cometd.service;

import javax.inject.Inject;

import com.mry.cometd.service.message.NotifyMessage;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ConfigurableServerChannel;
import org.cometd.bayeux.server.LocalSession;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Service
@Service
public class NotificationService {
	private static final Logger logger = LoggerFactory
			.getLogger(NotificationService.class);

	@Inject
	private BayeuxServer bayeuxServer;
	@Session
	private LocalSession sender;

	@Session
	private ServerSession serverSession;

	public void publish(NotifyMessage data) {
		logger.info("Push channel name: " + data.getChannel());
		bayeuxServer.createChannelIfAbsent(data.getChannel(),
				new ConfigurableServerChannel.Initializer() {
					public void configureChannel(
							ConfigurableServerChannel channel) {
						channel.setPersistent(true);
						channel.setLazy(true);
					}
				});

		ServerChannel channel = bayeuxServer.getChannel(data.getChannel());

		channel.publish(serverSession, data.toCometDData());
	}
}
