package api.application.model;

import java.lang.reflect.Field;

import api.application.entity.Category;
import api.application.utils.CateAnnotation;

public class CategoryInstance {
	@CateAnnotation(1)
	private static final Category CATE_01 = new Category("CATE01", "Fruit");
	@CateAnnotation(2)
	private static final Category CATE_02 = new Category("CATE02", "Vegetable");
	@CateAnnotation(3)
	private static final Category CATE_03 = new Category("CATE03", "Fast Food");
	@CateAnnotation(4)
	private static final Category CATE_04 = new Category("CATE04", "Drink");
	@CateAnnotation(5)
	private static final Category CATE_05 = new Category("CATE05", "Fresh Meat");
	@CateAnnotation(6)
	private static final Category CATE_06 = new Category("CATE06", "Egg");

	public static Category getCategory(int value) {
		Field[] fields = CategoryInstance.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				CateAnnotation annotation = field.getAnnotation(CateAnnotation.class);
				if (annotation.value()==value) {
					return (Category) field.get(Category.class.newInstance());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
