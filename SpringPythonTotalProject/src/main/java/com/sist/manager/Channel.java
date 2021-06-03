package com.sist.manager;
import java.util.*;
/*
 *    <rss>  ===> Rss
 *      <channel> ==> Channel
 *        <item>  ==> Item
 *          <title></title>
 *          <description></description>
 *          <author></author>
 *          <link></link>
 *        </item>
 *        <item>
 *        </item>
 *        <item>
 *        </item>
 *        ...
 *      </channel>
 *    </rss>
 */
public class Channel {
    private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}
	
	public void setItem(List<Item> item) {
		this.item = item;
	}
   
}
