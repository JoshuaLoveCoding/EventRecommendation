package rpc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {

	@Test
	public void testGetJSONArrayCornerCases() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		
		List<Item> listItem = new ArrayList<Item>();
		JSONArray jsonArray = new JSONArray();
		Item empty = new ItemBuilder().build();
		listItem.add(empty);
		jsonArray.put(empty.toJSONObject());
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		ItemBuilder itemBuilder = new ItemBuilder();
		itemBuilder.setItemId("one");
		itemBuilder.setRating(5);
		itemBuilder.setCategories(category);
		Item one = itemBuilder.build();
		ItemBuilder itemBuilder1 = new ItemBuilder();
		itemBuilder1.setItemId("two");
		itemBuilder1.setRating(3);
		itemBuilder1.setCategories(category);
		Item two = itemBuilder1.build();
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(one);
		listItem.add(two);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());
		
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
}


