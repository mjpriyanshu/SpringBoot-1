function Navigation() {
  return (
    <nav className="border-b border-slate-200 bg-white shadow-sm">
      <div className="mx-auto flex max-w-full w-full items-center justify-between px-4 py-3 sm:px-6">
        <a href="#" className="flex items-start gap-3">
          <img
            src="https://cdn.arstechnica.net/wp-content/uploads/2015/09/2000px-Wikipedia-logo-v2-en.jpg"
            alt="Logo"
            className="h-10 w-10 rounded-full object-cover border-ring"
          />
          <span className="text-lg font-semibold tracking-tight text-slate-900">
            WikiPedia
          </span>
        </a>

        <div className="flex items-center gap-6 text-sm font-medium text-slate-600">
          <a href="#" className="transition hover:text-blue-600">
            Home
          </a>
          <a href="#" className="transition hover:text-blue-600">
            Contact
          </a>
          <a href="#" className="transition hover:text-blue-600">
            About Us
          </a>
        </div>
      </div>
    </nav>
  )
}

export default Navigation
