import java.util.Locale;
import java.util.Scanner;

public class adventureDesigner {
	static sceneTree st;
	static Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args)
	{
		st=new sceneTree();
		String input="T";
		System.out.println("A) Add Scene");
		System.out.println("R) Remove Scene");
		System.out.println("S) Show Current Scene");
		System.out.println("P) Print Adventure Tree");
		System.out.println("B) Go Back A Scene");
		System.out.println("F) Go Forward A Scene");
		System.out.println("G) Play Game");
		System.out.println("N) Print Path To Cursor");
		System.out.println("M) Move Scene");
		System.out.println("Q) Quit\n\n");
		
		if(input=="T")
		{
			System.out.println("Creating a story...\n");
			
			System.out.println("Please enter a title:");
			String title=sc.nextLine();
			
			System.out.println("Please enter a scene:");
			String scene=sc.nextLine();
		
			st.addNewNode(title, scene);
			
			
		}
		System.out.println("\nPlease enter a selection");
		input=sc.nextLine();
		
		if(!input.equals("Q") || input.equals("q"))
		{
			while(!input.equals("Q") || !input.equals("q"))
			{
				
				if(input.equals("A") || input.equals("a"))
				{
					System.out.println("Please enter a title:");
					String title=sc.nextLine();
					
					System.out.println("Please enter a scene:");
					String scene=sc.nextLine();
					
						st.addNewNode(title, scene);
					
					
				}
				else if(input.equals("R") || input.equals("r"))
				{
					System.out.println("\nPlease enter an option:\n");
					String option=sc.nextLine();
					try {
						st.removeScene(option);
					} catch (NoSuchNodeException e) {
						
						System.out.println("File path doesn't exist.\n");
						continue;
					}
					
				}
				else if(input.equals("S") || input.equals("s"))
				{
					st.getCursor().displayScene();
				}
				else if(input.equals("P") || input.equals("p"))
				{
					System.out.println('\n'+st.toString());
				}
				else if(input.equals("F") || input.equals("f"))
				{
					System.out.println("Which option do you wish to go:");
					String option=sc.nextLine();
					option.toUpperCase();
					try {
						st.moveCursorForwards(option);
						System.out.println("Successfully moved to "+st.cursor.getTitle()+"\n");
					} catch (NoSuchNodeException e) {
						System.out.println("The option does not exist.\n");
					}
				}
				else if(input.equals("B") || input.equals("b"))
				{
					try {
						st.moveCursorBackwards();
						System.out.println("Successfully moved to "+st.cursor.getTitle()+"\n");
						
					} catch (NoSuchNodeException e) {
						System.out.println("No parent scene\n");
					}
				}
				else if(input.equals("N") || input.equals("n"))
				{
					System.out.println(st.getPathFromRoot());
				}
				else if(input.equals("G") || input.equals("g"))
				{
					playGame();
				}
				else if(input.equals("M") || input.equals("m"))
				{
					System.out.println("Move current scene to");
					int id=sc.nextInt();
					try {
						st.moveScene(id);
						System.out.println("Successfully moved scene");
					} catch (FullSceneException e) {
						System.out.println("You cannot add  scene here now\n");
					}
				}
				
				
				System.out.println("Please enter a selection");
				input=sc.nextLine();
				input.toUpperCase(Locale.ROOT);
					
			}
		}
		else
		System.out.println("Program terminating normally...\n\n");
			
		
	}
	
	
	
	public static void playGame()
	{
		sceneNode temp=st.getRoot();
		System.out.println("Now beginnin game...\n");
		
		temp.displayFullScene();
		
		while(!temp.isEnding())
		{
			System.out.println("Please enter an option:");
			String option=sc.nextLine();
			try {
				if(option.equals("A") || option.equals("a"))
				{
					if(temp.getLeft()!=null)
					{
						temp=temp.getLeft();
						temp.displayFullScene();
					}
					else
						throw new NoSuchNodeException();
				}
				else if(option.equals("B") || option.equals("b"))
				{
					if(temp.getMiddle()!=null)
					{
						temp=temp.getMiddle();
						temp.displayFullScene();
					}
					else
						throw new NoSuchNodeException();
				}
				else if(option.equals("C") || option.equals("c"))
				{
					if(temp.getRight()!=null)
					{
						temp=temp.getRight();
						temp.displayFullScene();
					}
					else
						throw new NoSuchNodeException();
				}
			
			} catch (NoSuchNodeException e) {
				
				
			}
		}
		System.out.println("The End\n");
		System.out.println("Returning back to creation mode...\n");
		
		
	}

}
