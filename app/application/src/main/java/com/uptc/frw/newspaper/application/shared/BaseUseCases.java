package com.uptc.frw.newspaper.application.shared;

import java.util.*;

public abstract class BaseUseCases<Entity> {
    public abstract Entity add(final Entity input);
    public abstract Optional<Entity> remove(final Long entityId);
    public abstract List<Entity> listAll();
    public abstract Optional<Entity> get(final Long entityId);
    public abstract Optional<Entity> update(final Entity input, final Long entityId);
}
