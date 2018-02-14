package data;

public class JustSomeCode {
	/**
	 * Well, I stole this from some of my C# code.
	 */
	/*if (itemImage != null && ply.imageItem == null) {
		ply.imageItem = itemImage;
		itemImage = null;
	} else {
		itemImage = ply.imageItem;
		ply.imageItem = null;
	}*/
	
	/*if (stack!=null) {
	if (stack.getBlock() == null) {
		if (PlayerSelf.stackInHand == null) {
			// Both are null. Returning
			System.out.println("dope");
			return;
		} else {
			stack = PlayerSelf.stackInHand;
			PlayerSelf.stackInHand = null;
			System.out.println("yope");
			return;
		}
	} else {
		if (PlayerSelf.stackInHand == null) {
			PlayerSelf.stackInHand = stack;
			stack=null;
			System.out.println("true");
			return;
		} else {
			//both are not null
			ItemStack tempItem = PlayerSelf.stackInHand;
			PlayerSelf.stackInHand =stack;
			stack = tempItem;
			tempItem =null;
			System.out.println("false");
			return;
		}
	}
}*/

/*if(stack != null && PlayerSelf.stackInHand != null){
	ItemStack tempItem = PlayerSelf.stackInHand;
	PlayerSelf.stackInHand =stack;
	stack = tempItem;
	tempItem =null;
	System.out.println("false");
	return;
} else {
	if (stack != null && PlayerSelf.stackInHand == null) {
		PlayerSelf.stackInHand = stack;
		stack = null;
	} else {
		stack = PlayerSelf.stackInHand;
		PlayerSelf.stackInHand = null;
	}
}*/
}
