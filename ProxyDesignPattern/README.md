# Proxy Design Pattern

## What is Proxy Design Pattern?
The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It involves creating an intermediary object that acts as a substitute for another object, allowing for additional functionality to be added without changing the original object's code.

## Why do we need it?
Proxy pattern is used to control access to an object, allowing for various purposes such as managing the creation of expensive objects, providing security, implementing lazy initialization, or adding a level of abstraction.

## When do we need it?
1. **Remote Proxy:**
   1. In distributed systems, when dealing with remote objects located on different servers, a proxy can act as a local representative for a remote object, providing a local interface to interact with the remote object.
   2. Ex. Remote Method Invocation (RMI) in Java uses proxies for communication between client and server. The client interacts with a local proxy object, which internally communicates with the remote object on the server. 
2. **Virtual Proxy:**
   1. Useful when dealing with resource-intensive objects that are expensive to create. A virtual proxy defers the creation of the real object until it is accessed, thus optimizing resource utilization. 
   2. Ex. Loading large images or files in a document or web page. The proxy object initially holds a placeholder or small-sized image, and when required, it loads the full-size image, reducing initial loading times.
3. **Protection Proxy:**
   1. Used to control access to sensitive objects or resources by implementing access control mechanisms.
   2. Security measures like authentication, authorization, or logging access to certain operations. For instance, a proxy can restrict certain operations on a real object based on the user's permissions.
4. **Caching Proxy:**
   1. Caches the results of operations from the real object and returns the cached results when the same operation is requested again, improving performance.
   2. Ex. Storing frequently accessed data in the proxy to avoid repeated computations or expensive operations. For example, caching database query results to reduce query times.
5. **Synchronization Proxy:**
   1. Manages concurrent access to the real object by synchronizing multiple clients' requests.
   2. Ex. Ensuring thread safety in a multi-threaded environment by synchronizing access to the real object's methods, preventing race conditions or inconsistencies.

## How can it be implemented?
The implementation of Proxy Design Pattern involves:
1. Creating an interface that both the proxy and the real subject implement.
2. Developing a proxy class that acts as an intermediary, holding a reference to the real subject.
3. Implementing the proxy methods to control access to the real subject by adding additional functionalities as required.
4. Using the proxy class to access the real subject.

