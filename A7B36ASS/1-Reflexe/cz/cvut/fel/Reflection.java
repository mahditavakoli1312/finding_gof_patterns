package cz.cvut.fel;

import java.util.Date;

public class Reflection {

		public static void main(String[] args){
			Serializer s = new Serializer();
			Author a = new Author("Martin", "Omáčka", new Date(1959, 10, 23));
			Book b = new Book("433-13456787", a, 123, 3.4);
			s.serialize(b);
		}
}
