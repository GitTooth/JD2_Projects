package by.epam.library.view;

import by.epam.library.controller.Controller;

public final class View {
	private static final Controller CONTROLLER = new Controller();

	public static void main(String [] args){
		String response = null;
		
//		##Initialization DB connection##
		response = CONTROLLER.executeAction("initialization_source ");
		PrintResponse.out(response);
		
		
//		##Sign up user
		response = CONTROLLER.executeAction("sign_up Vasilii_Pupkin 12345678");
		PrintResponse.out(response);
		
// 		##Sign in user
		response = CONTROLLER.executeAction("sign_in Vasilii_Pupkin 12345678");
		PrintResponse.out(response);

// 		##Add new book
//		Example: add_new_book Title Genre Author Year Quantity
		response = CONTROLLER.executeAction("add_new_book MyBook Vasya_Pupkin Action 2017 2");
		PrintResponse.out(response);
		
// 		##Add edit book
//		Example: add_edit_book Title Genre Author Year Quantity idBook
		response = CONTROLLER.executeAction("add_edit_book MyBook Ne_Petya_Pupkin Action 2017 2 7");
		PrintResponse.out(response);

		
//		##Get booklist
		CONTROLLER.executeAction("get_booklist ");
		PrintResponse.out(response);

		
// 		##Remove book
//		Example: remove_book idBook
//		response = CONTROLLER.executeAction("remove_book 10");
//		PrintResponse.out(response);

		
//		##Destroy DB connection##
		response = CONTROLLER.executeAction("destroy_source ");
		PrintResponse.out(response);
	}
}
