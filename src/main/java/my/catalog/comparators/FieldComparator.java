package my.catalog.comparators;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class FieldComparator<B extends Comparable> implements Comparator<B> {
	private boolean isForwardOrder;

	public FieldComparator(boolean isForwardOrder) {
		this.isForwardOrder = isForwardOrder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compare(B o1, B o2) {
		if (o1 == o2)
			return 0;
		if (o1 == null)
			return 1;
		if (o2 == null)
			return -1;
		if (isForwardOrder)
			return o1.compareTo(o2);
		return o2.compareTo(o1);
	}

}
