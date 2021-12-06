package domain;

import java.util.List;
import java.util.Objects;

public class Position {
    private static final int MOVE_DISTANCE = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isMovableLeft(List<Boolean> floor) {
        checkPosition(floor.size());

        return position > 0 && floor.get(position-1);
    }

    public Position moveLeft() {
        return new Position(position - MOVE_DISTANCE);
    }

    public boolean isMovableRight(List<Boolean> floor) {
        checkPosition(floor.size());

        return position < floor.size() && floor.get(position);
    }

    public Position moveRight() {
        return new Position(position + MOVE_DISTANCE);
    }

    private void checkPosition(int floorSize) {
        if (position < 0 || position > floorSize) {
            throw new IndexOutOfBoundsException("Position is out of bounds");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position1 = (Position) object;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
