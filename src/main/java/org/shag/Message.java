package org.shag;

/**
 * org.shag.Message POJO with Builder
 * Created by Twosmiles on 21.05.2017.
 */
public class Message {
    private final String text;
    private final String from;
    private final String to;

    public Message(String text, String from, String to) {
        this.text = text;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format("From %s, %s to %s", from, text, to);
    }

    public static final class MessageBuilder {
        private String text;
        private String from;
        private String to;

        private MessageBuilder() {
        }

        public static MessageBuilder aMessage() {
            return new MessageBuilder();
        }

        public MessageBuilder text(String text) {
            this.text = text;
            return this;
        }

        public MessageBuilder from(String from) {
            this.from = from;
            return this;
        }

        public MessageBuilder to(String to) {
            this.to = to;
            return this;
        }

        public Message build() {
            Message message = new Message(text, from, to);
            return message;
        }
    }
}
