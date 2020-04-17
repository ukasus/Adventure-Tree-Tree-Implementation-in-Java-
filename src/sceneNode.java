
public class sceneNode {
	String title;
	String sceneDescription;
	int sceneId;
	sceneNode left;
	sceneNode middle;
	sceneNode right;
	sceneNode parent;
	static int numScenes=0;
	
	
	public void addScene(sceneNode scene) throws FullSceneException
	{
		if(left==null || middle==null || right==null)
		{
			numScenes++;
			scene.setSceneId(numScenes);
			if(left==null)
				left=scene;
			else if(middle==null)
				middle=scene;
			else if(right==null)
				right=scene;
			
			System.out.println("Scene #"+scene.sceneId+" added");
		}
		else
			throw new FullSceneException();
	}
	public boolean isEnding() 
	{
		if(left==null && middle==null && right==null)
			return true;
		return false;
		
	}
	public void displayScene()
	{
		System.out.println("Scene ID #"+sceneId);
		System.out.println("Title:"+title);
		System.out.println("Scene:"+sceneDescription);
		if(left!=null)
			System.out.println("Leads to:"+left.getTitle());
		else if(middle!=null)
			System.out.println("Leads to:"+middle.getTitle());
		else if(right!=null)
			System.out.println("Leads to:"+right.getTitle());
		else
			System.out.println("Leads to: None");
			
		
		
	}
	public void displayFullScene()
	{
		String playgame="";
		playgame+=title+'\n';
		playgame+=sceneDescription+'\n';
		try {
			playgame+="A) "+left.getTitle()+'\n';
		} catch (Exception e) {
			
			
		}
		try {
			playgame+="B) "+middle.getTitle()+'\n';
		} catch (Exception e) {
		
		
		}
		try {
			playgame+="C) "+right.getTitle()+'\n';
		} catch (Exception e) {
			
		}
		
		System.out.println(playgame);
		
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSceneDescription() {
		return sceneDescription;
	}
	public void setSceneDescription(String sceneDescription) {
		this.sceneDescription = sceneDescription;
	}
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public sceneNode getLeft() {
		return left;
	}
	public void setLeft(sceneNode left) {
		this.left = left;
	}
	public sceneNode getMiddle() {
		return middle;
	}
	public void setMiddle(sceneNode middle) {
		this.middle = middle;
	}
	public sceneNode getRight() {
		return right;
	}
	public void setRight(sceneNode right) {
		this.right = right;
	}
	public static int getNumScenes() {
		return numScenes;
	}
	public static void setNumScenes(int numScenes) {
		sceneNode.numScenes = numScenes;
	}
	
	
	public sceneNode getParent() {
		return parent;
	}
	public void setParent(sceneNode parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return title+" (#" +sceneId +")" ;
	}
	
	
	

}
