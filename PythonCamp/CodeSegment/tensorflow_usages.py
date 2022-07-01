# TensorFlow usages

# 使用TensorFlow人脸识别
# Import the necessary packages
import tensorflow as tf


def create_weights(shape):
    return tf.Variable(tf.truncated_normal(shape, stddev=0.05))


def create_biases(size):
    return tf.Variable(tf.constant(0.05, shape=[size]))


def create_convolutional_layer(input, num_input_channels, num_filters, filter_shape, pool_shape, name):
    with tf.name_scope(name):
        weights = create_weights(shape=filter_shape)
        biases = create_biases(num_filters)
        layer = tf.nn.conv2d(input=input, filter=weights, strides=[
                             1, 1, 1, 1], padding='SAME')
        layer += biases
        layer = tf.nn.max_pool(
            value=layer, ksize=pool_shape, strides=pool_shape, padding='SAME')
        layer = tf.nn.relu(layer)
        return layer


def create_flatten_layer(layer):
    layer_shape = layer.get_shape()
    num_features = layer_shape[1:4].num_elements()
    layer = tf.reshape(layer, [-1, num_features])
    return layer


def create_fc_layer(input, num_inputs, num_outputs, name):
    with tf.name_scope(name):
        weights = create_weights(shape=[num_inputs, num_outputs])
        biases = create_biases(num_outputs)
        layer = tf.matmul(input, weights) + biases
        layer = tf.nn.relu(layer)
        return layer


def create_model(x):
    # Create the convolutional layers
    layer_conv1 = create_convolutional_layer(input=x, num_input_channels=1, num_filters=32, filter_shape=[
                                             5, 5], pool_shape=[2, 2], name='layer_conv1')
    layer_conv2 = create_convolutional_layer(input=layer_conv1, num_input_channels=32, num_filters=64, filter_shape=[
                                             5, 5], pool_shape=[2, 2], name='layer_conv2')
    # Create the flatten layer
    layer_flat = create_flatten_layer(layer_conv2)
    # Create the fully-connected layer
    layer_fc1 = create_fc_layer(
        input=layer_flat, num_inputs=1024, num_outputs=128, name='layer_fc1')
    # Create the output layer
    layer_fc2 = create_fc_layer(
        input=layer_fc1, num_inputs=128, num_outputs=10, name='layer_fc2')
    return layer_fc2


def train_neural_network(x):
    prediction = create_model(x)
    cost = tf.reduce_mean(
        tf.nn.softmax_cross_entropy_with_logits(logits=prediction, labels=y))
    optimizer = tf.train.AdamOptimizer().minimize(cost)
    with tf.Session() as sess:
        sess.run(tf.global_variables_initializer())
        for epoch in range(hm_epochs):
            epoch_loss = 0
            for _ in range(int(mnist.train.num_examples / batch_size)):
                epoch_x, epoch_y = mnist.train.next_batch(batch_size)
                _, c = sess.run([optimizer, cost], feed_dict={
                                x: epoch_x, y: epoch_y})
                epoch_loss += c
            print('Epoch', epoch, 'completed out of',
                  hm_epochs, 'loss:', epoch_loss)
        correct = tf.equal(tf.argmax(prediction, 1), tf.argmax(y, 1))
        accuracy = tf.reduce_mean(tf.cast(correct, 'float'))
        print('Accuracy:', accuracy.eval(
            {x: mnist.test.images, y: mnist.test.labels}))


if __name__ == '__main__':
    train_neural_network(x)
