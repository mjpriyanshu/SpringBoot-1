import React, { useState } from 'react';

function Contact() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [submittedData, setSubmittedData] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmittedData({ name, email, message });
    setName('');
    setEmail('');
    setMessage('');
  };

  return (
    <div className="flex flex-col items-center justify-center bg-slate-50 px-4 py-12 sm:px-6 lg:px-8 space-y-6">
      {/* Two Buttons on top of the Form Card Container */}
      <div className="flex w-full max-w-4xl justify-start gap-3">
        <button type="button" className="rounded-lg bg-black px-4 py-2 text-sm font-semibold text-white shadow-sm hover:bg-slate-800 transition duration-150">
          Option One
        </button>
        <button type="button" className="rounded-lg bg-black px-4 py-2 text-sm font-semibold text-white shadow-sm hover:bg-slate-800 transition duration-150">
          Option Two
        </button>
      </div>

      {/* Main Split Interface Wrapper */}
      <div className="grid w-full max-w-4xl grid-cols-1 overflow-hidden rounded-2xl bg-white shadow-sm border border-slate-100 md:grid-cols-2">
        
        {/* Left Side: Form Elements */}
        <div className="p-8">
          <div>
            <h2 className="text-2xl font-bold tracking-tight text-slate-900">
              Get in touch
            </h2>
          </div>

          <form onSubmit={handleSubmit} className="mt-6 space-y-4">
            <div>
              <label htmlFor="name" className="block text-sm font-medium text-slate-700">
                Full Name
              </label>
              <input
                id="name"
                type="text"
                required
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="John Doe"
                className="mt-1 block w-full rounded-lg border border-slate-200 px-3 py-2 text-slate-900 placeholder-slate-400 shadow-sm focus:border-black focus:outline-none focus:ring-1 focus:ring-black text-sm"
              />
            </div>

            <div>
              <label htmlFor="email" className="block text-sm font-medium text-slate-700">
                Email Address
              </label>
              <input
                id="email"
                type="email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="you@example.com"
                className="mt-1 block w-full rounded-lg border border-slate-200 px-3 py-2 text-slate-900 placeholder-slate-400 shadow-sm focus:border-black focus:outline-none focus:ring-1 focus:ring-black text-sm"
              />
            </div>

            <div>
              <label htmlFor="message" className="block text-sm font-medium text-slate-700">
                Message
              </label>
              <textarea
                id="message"
                rows="4"
                required
                value={message}
                onChange={(e) => setMessage(e.target.value)}
                placeholder="Leave us a message..."
                className="mt-1 block w-full rounded-lg border border-slate-200 px-3 py-2 text-slate-900 placeholder-slate-400 shadow-sm focus:border-black focus:outline-none focus:ring-1 focus:ring-black text-sm resize-none"
              />
            </div>

            <div>
              <button
                type="submit"
                className="flex w-full justify-center rounded-lg bg-black px-4 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-slate-800 transition duration-150"
              >
                Send Message
              </button>
            </div>
          </form>
        </div>

        {/* Right Side: Image Panel Fixes applied here */}
        <div className="hidden bg-slate-50 md:flex items-center justify-center border-l border-slate-100 p-6">
          <img 
            src="https://www.webopedia.com/wp-content/uploads/1996/09/customer-support.webp" 
            alt="Customer Support Illustration" 
            className="h-auto max-h-[350px] w-full max-w-sm object-contain mix-blend-multiply"
          />
        </div>

      </div>

      {/* Conditionally Render Output Below everything */}
      {submittedData && (
        <div className="w-full max-w-4xl rounded-2xl bg-white p-6 shadow-sm border border-emerald-100 bg-emerald-50/20">
          <h3 className="text-sm font-semibold text-emerald-800 mb-4 flex items-center gap-2">
            <span>✓</span> Submitted Data Summary:
          </h3>
          <div className="space-y-2 text-sm text-slate-700">
            <p><strong className="text-slate-900">Name:</strong> {submittedData.name}</p>
            <p><strong className="text-slate-900">Email:</strong> {submittedData.email}</p>
            <p className="whitespace-pre-wrap"><strong className="text-slate-900">Message:</strong> {submittedData.message}</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default Contact;
