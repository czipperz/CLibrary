package io.github.czipperz.cLibrary.collision

/**
 * Created by czipperz on 4/9/15.
 */
final class CCollision implements Serializable {
	private boolean[][] stat;

	CCollision() {}

	protected CCollision(boolean[][] b) {
		stat = b
	}

	CCollision(CCollision c) {
		stat = c.get().clone()
	}

	public boolean[][] get() {
		return stat
	}

	public int getLength() {
		return stat.length
	}

	public int getLength(int i) {
		try {
			return stat[i].length
		} catch(IndexOutOfBoundsException e) {
			return stat[0].length
		}
	}

	protected void set(boolean[][] b) {stat = b}

	protected void set(int x, int y, boolean b) {
		stat[x][y] = b
	}

	public CCollision clone() {
		return new CCollision(this)
	}
}
