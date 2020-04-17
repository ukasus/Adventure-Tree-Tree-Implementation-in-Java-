
public class sceneTree {
	sceneNode root;
	sceneNode cursor;
	sceneNode move;
	
	
	public void moveCursorBackwards() throws NoSuchNodeException
	{
		if(cursor==root)
			throw new NoSuchNodeException();
		else
		{
			cursor=cursor.getParent();
		}
		
	}
	public void moveCursorForwards(String option) throws NoSuchNodeException
	{
		if(option.equals("A"))
		{
			if(cursor.left!=null)
				cursor=cursor.left;
			else
				throw new NoSuchNodeException();
		}
		else if(option.equals("B"))
		{
			if(cursor.middle!=null)
				cursor=cursor.middle;
			else
				throw new NoSuchNodeException();
		}
		else if(option.equals("C"))
		{
			if(cursor.right!=null)
				cursor=cursor.right;
			else
				throw new NoSuchNodeException();
		}
		
	}
	public void addNewNode(String title,String sceneDescription) 
	{
		
		if(sceneNode.numScenes==0)
		{
			sceneNode.numScenes++;
			sceneNode addnode=new sceneNode();
			addnode.setTitle(title);
			addnode.setSceneDescription(sceneDescription);
			addnode.setSceneId(sceneNode.numScenes);
			addnode.setParent(null);
			root=addnode;
		    cursor=addnode;
		    System.out.println("Scene #"+addnode.sceneId+" added\n");
		}
		else
		{
			sceneNode addnode=new sceneNode();
			addnode.setTitle(title);
			addnode.setSceneDescription(sceneDescription);
			
			try
			{
				cursor.addScene(addnode);
				addnode.setParent(cursor);
			}
			catch(FullSceneException ee)
			{
				System.out.println("You cannot add  scene here now");
			}
		}
		
		
		
	}
	public void removeScene(String option) throws NoSuchNodeException
	{

		
		
			if(option.equals("A") || option.equals("a"))
			{
				if(cursor.left!=null)
					cursor.left=null;
				else
					throw new NoSuchNodeException();
			}
			else if(option.equals("B") || option.equals("b"))
			{
				if(cursor.middle!=null)
					cursor.middle=null;
				else
					throw new NoSuchNodeException();
			}
			else if(option.equals("C") || option.equals("c"))
			{
				if(cursor.right!=null)
					cursor.right=null;
				else
					throw new NoSuchNodeException();
			}
			System.out.println("File path removed.");
		
		
	}
	public void moveScene(int sceneIdToMoveTo) throws FullSceneException
	{
	   getid(sceneIdToMoveTo,root);	
	   if(move.getLeft()==null|| move.getMiddle()==null ||move.getRight()==null)
	   {
		   if(move.getLeft()==null)
			   move.setLeft(cursor);
		   else if(move.getMiddle()==null)
			   move.setMiddle(cursor);
		   else if(move.getRight()==null)
			   move.setRight(cursor);
	   }
	   else
		   throw new FullSceneException();
	   
	   try {
		if(cursor.getParent().getLeft().getSceneId()==cursor.getSceneId())
		   {
			   cursor.getParent().setLeft(null);
		   }
	       } catch (Exception e) {
		
	       }
	    try {
			if(cursor.getParent().getMiddle().getSceneId()==cursor.getSceneId())
            {
			   cursor.getParent().setMiddle(null);
             }
		    } catch (Exception e) {
			
		    }
	    try {
			if(cursor.getParent().getRight().getSceneId()==cursor.getSceneId())
              {
			   cursor.getParent().setRight(null);
              }
		      } catch (Exception e) {
			
		     }
	   cursor.setParent(move);
	   
	   
	   
	}
	public String getPathFromRoot()
	{
		 String path="";
		sceneNode temp=cursor;
		while(temp!=root)
		{
			path+=(temp.getTitle()+",");
			temp=temp.getParent();
		}
		path+=(root.getTitle());
		String[] pa=path.split(",");
		path="";
		for(int i=pa.length-1;i>=0;i--)
		{
			if(i==0)
				path+=pa[i];
			else
				path+=pa[i]+", ";
		}
			
		
		return path;
		
	}
	String printtree="";
	public String toString()
	{
		printtree="";
		printtree("",0,root);
		 return printtree;
		
		
	}
	public sceneNode getRoot() {
		return root;
	}
	public void setRoot(sceneNode root) {
		this.root = root;
	}
	public sceneNode getCursor() {
		return cursor;
	}
	public void setCursor(sceneNode cursor) {
		this.cursor = cursor;
	}
	
	public void getid(int id ,sceneNode cursor)
	{
		try {
			if(cursor.getSceneId()==id)
			{
				move=cursor;
				
				return;
			}
			else
			{
				
				getid(id,cursor.left);
				getid(id,cursor.middle);
				getid(id,cursor.right);
			}
		} catch (Exception e) {
			return;
		}
		return ;
	}
	
	public void printtree(String ind,int count ,sceneNode cursor)
	{
		try {
			if(cursor==null)
			{
				return;
			}
			else
			{
				for(int i=0;i<count;i++)
				{
					
					printtree+="  ";
				}
				printtree+=ind+cursor.getTitle()+" (#"+cursor.getSceneId()+")";
				if(cursor.getSceneId()==this.cursor.getSceneId())
				{
					printtree+=" *\n";
				}
				else 
					printtree+='\n';
				
				count++;
				printtree("A) ",count,cursor.left);
				printtree("B) ",count,cursor.middle);
				printtree("C) ",count,cursor.right);
			}
		} catch (Exception e) {
			return;
		}
		return ;
	}
	
}
