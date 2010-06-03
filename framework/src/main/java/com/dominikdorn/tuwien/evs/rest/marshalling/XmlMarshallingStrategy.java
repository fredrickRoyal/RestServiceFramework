package com.dominikdorn.tuwien.evs.rest.marshalling;

import com.dominikdorn.tuwien.evs.rest.services.RemotingError;
import com.skaringa.javaxml.*;

/**
 * Dominik Dorn
 * 0626165
 * dominik.dorn@tuwien.ac.at
 */
public class XmlMarshallingStrategy implements MarshallingStrategy {
    @Override
    public Object deSerialize(String data, Class clazz) throws RemotingError {
        try {
            ObjectTransformer trans =
                    ObjectTransformerFactory.getInstance().getImplementation();

            return trans.deserializeFromString(data);
        } catch (NoImplementationException e) {
            throw new RemotingError(2, "Couldn't load serialization-implementation");
        } catch (DeserializerException e) {
            throw new RemotingError(4, "Failed to deSerialize the given String to an Object");
        }
        catch (Exception e) {
            throw new RemotingError(5, "General Error during deSerialization from String to an Object");
        }
    }

    @Override
    public String serialize(Object object, Class clazz) throws RemotingError {
        try {
            ObjectTransformer trans =
                    ObjectTransformerFactory.getInstance().getImplementation();

            return trans.serializeToString(object);
        } catch (NoImplementationException e) {
            throw new RemotingError(2, "Couldn't load serialization-implementation");
        } catch (SerializerException e) {
            throw new RemotingError(3, "Error during serialization of the given object");
        }
        catch (Exception e) {
            throw new RemotingError(5, "General Error during serialization from an Object to a String");
        }

    }
}
