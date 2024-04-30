package edu.utdallas.cs4485.team45.server.entities;
    public class Card {
        public enum Color {
            RED, BLUE, GREEN, YELLOW, BLACK
        }

        public enum Type {
            NUM, SKIP, REVERSE, DRAW_TWO, WILD, /*WILD_DRAW_FOUR*/
        }

        int id;
        private Color color;
        private Type type;
        private int num; //only assign if type is num


        public Card(Color color, int num) {
            this.color = color;
            this.type = Type.NUM;
            this.num = num;
        }

        public Card(Color color, Type type) {
            this.color = color;
            this.type = type;
        }

        public Card.Color getColor() {
            return color;
        }

        public Type getType() {
            return type;
        }

        public int getNum() {
            return num;
        }

        public int getId(){
            return id;
        }

        @Override
        public String toString() {
            if (type == Type.NUM) {
                return color + " " + num;
            } else {
                return color + " " + type;
            }
        }

    }
