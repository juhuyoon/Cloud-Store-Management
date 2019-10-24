package com.company.levelupservice.consumer;

import com.company.levelupservice.model.LevelUp;
import com.company.levelupservice.model.LevelViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

        @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
        public void receiveMessage(LevelViewModel lvm) {
            if (lvm.getLevel_up_id() > 0) {
                client.updateComment(cmt);
            } else {
                client.createComment(cmt);
            }
        }
}
