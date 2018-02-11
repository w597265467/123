package test;

import java.io.UnsupportedEncodingException;

public class TestUnreadableCode {
	public static void main(String[] arg) throws UnsupportedEncodingException {
	    String s = "订单无效";
	    String sss = new String(s.getBytes("utf-8"),"GBK");
		System.out.println("s:\t"+s);
		System.out.println("String sss = new String(s.getBytes(\"utf-8\"),\"GBK\");");
		System.out.println("sss:\t"+sss);
		//	public static BqxdDataRelationshipEnum getRelative(String desc){
//		if (StringUtils.isEmpty(desc)){
//			return null;
//		}
//		if (desc.equals(CHILDREN.desc)){
//			return CHILDREN;
//		}
//		if (desc.equals(PARENT.desc)){
//			return PARENT;
//		}
//		if (desc.equals(COUPLE_PARENT.desc)){
//			return COUPLE_PARENT;
//		}
//		if (desc.equals(COUPLE_PARENT.desc)){
//			return CHILDREN;
//		}
//		if (desc.equals(CHILDREN_COUPLE.desc)){
//			return CHILDREN_COUPLE;
//		}
//		if (desc.equals(BROTHER_SISTER.desc)){
//			return BROTHER_SISTER;
//		}
//		if (desc.equals(COLLEAGUE.desc)){
//			return COLLEAGUE;
//		}
//		if (desc.equals(CLASSMATE.desc)){
//			return CLASSMATE;
//		}
//		if (desc.equals(FRIEND.desc)){
//			return FRIEND;
//		}
//		if (desc.equals(OTHER_RELATIVE.desc)){
//			return OTHER_RELATIVE;
//		}
//		return null;
//	}
	}

}
