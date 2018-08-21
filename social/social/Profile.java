package social;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Profile{
    private String name;
    private List<Post> timeline = new ArrayList<>();
    private List<Profile> follows = new ArrayList<>();

    public Profile( String name ){
        this.name = name;
    }

    public boolean addFollow( Profile profile ){
        if( follows.indexOf( profile ) == -1 ){
            follows.add( profile );
            return true;
        }
        return false;
    }

    public void postMessage( String message ){
        timeline.add( 0, new Post( message, getName() ));
    }

    public String getName(){
        return name;
    }

    public List<Post> getTimeline(){
        return this.timeline;
    }

    public List<Profile> getFollows(){
        return this.follows;
    }

    @Override
    public boolean equals( Object o ){
        if( !( o instanceof Profile )){
            return false;
        }

        Profile profile = ( Profile )o;
        return profile.getName() != null && profile.getName().equals( this.getName());
    }
    
    public List<Post> getWall() {
    	List<Post> wall = new ArrayList<>();
    	wall.addAll( getTimeline());
    	for( Profile profile : getFollows()) {
    		wall.addAll( profile.getTimeline());
    	}
    	
    	Collections.sort( wall, new Comparator<Post>() {

			@Override
			public int compare(Post o1, Post o2) {
				if( o1.getDate().getTime() > o2.getDate().getTime()) {
					return -1;
				}
				else if( o1.getDate().getTime() < o2.getDate().getTime() ) {
					return 1;
				}
				return 0;
			}
		});
    	
    	return wall;
    }
}