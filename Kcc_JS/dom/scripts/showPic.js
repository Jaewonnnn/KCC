function showPic(obj) {
  const source = obj.getAttribute("href");

  const placeholder = document.getElementById("placeholder");
  placeholder.setAttribute("src", source);

  const text = obj.getAttribute("title");
  const description = document.getElementById("description");
  if (description.firstChild.nodeType === 3) {
    description.firstChild.nodeValue = text;
  }
  //description.innerHTML = title;

  // innerHTML이 계속해서 쌓임
  // description.insertAdjacentHTML('beforeend', text);
}

// e.preventDefault() // 기본이벤트 취소
function prepareGallery() {
  const imagegallery = document.getElementById("imagegallery");
  // ul태그 아래의 a태그만 뽑아옴
  const links = imagegallery.getElementsByTagName("a");

  // 파라미터에 아무 값이나 넣어도 event가 넘어온다
  for (let i = 0; i < links.length; i++) {
    links[i].addEventListener(
      "click",
      function (e) {
        // return false;
        e.preventDefault();
        showPic(links[i]);
      },
      false
    );
  }
}
window.onload = prepareGallery;
