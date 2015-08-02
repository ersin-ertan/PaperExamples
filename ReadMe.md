###Problem

Paper requires it's methods to be call off the main thread. I created an intent service with @IntentBuilder and encapsulated the calls, however, I had not thought of returning the call return values thus two solutions came to mind, EventBus and a ResultReceiver.

This made me think of the implementation being the problem, and I thought that a different service type should be use to communicate from the background to the activity to pass the results.

I would like to try to solve the problem without the use of services, but my using an asynctask variant. I have already implemented an asynctask encapsulating the calls, as a static inner class, and using onPostExecute to manipulate the outer class variables, but the implementation big and asynctask has its faults when transitioning from onDestroy to onCreate, as it recreates itself and does the call again.
To this, I think there is a method to give asynctask an onCancel check by wrapping the logic in a boolean isRunning, thus leaving only the problem of tight coupling an large code footprint. Because Paper's tasks should be quite short(ms) asynctask is still a possible solution.

The variant of asynctask that I would like to explore is Facebook's Bolts:Tasks framework: a Task is returned from an asynchronous function and gives the ability to continue processing the result of the task. Tasks are fully composable, allowing you to perform branching, parallelism, and complex error handling, along with completing Tasks in series.
Because of this functionality, and by consuming fewer system resources, since they don't occupy a thread while waiting on other tasks to complete, I would like to explore the possibilities of using task in conjunction with Paper to keep the call responsive and in the scope of the calling activity without having to initiate a Service.

TODO - Learn bolts:tasks, then finish the implementation, for now use an AsyncTask(and not the intent service, unless you want to implement EventBus).
