import SocketServer

class MyTCPHandler(SocketServer.BaseRequestHandler):
    """
    The RequestHandler class for our server.

    It is instantiated once per connection to the server, and must
    override the handle() method to implement communication to the
    client.
    """

    def handle(self):
        # self.request is the TCP socket connected to the client
        self.data = self.request.recv(1024).strip()
        #print "{} wrote:".format(self.client_address[0])
	print "ClientIP:", self.client_address[0]
        print "Rx: ", self.data
        # just send back the same data, but upper-cased
        #self.request.sendall(self.data.upper())
	s = "John Doe,99,1:40pm,Nov 2nd,2014"
	print "Tx: ", s
	self.request.sendall( s )

if __name__ == "__main__":
    HOST, PORT = "192.168.1.130", 9999

    # Create the server, binding to localhost on port 9999
    server = SocketServer.TCPServer((HOST, PORT), MyTCPHandler)
    print
    print "Started: %s   Port: %d" % ( HOST, PORT )
    print "Server: ", server
    print

    # Activate the server; this will keep running until you
    # interrupt the program with Ctrl-C
    server.serve_forever()
